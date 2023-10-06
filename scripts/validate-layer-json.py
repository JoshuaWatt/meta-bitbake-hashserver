#! /usr/bin/env python3
#
# Copyright (c) 2023 Garmin Ltd. or its subsidiaries

import argparse
import sys
import json
import subprocess
from pathlib import Path


THIS_DIR = Path(__file__).parent


def main():
    parser = argparse.ArgumentParser(description="Validate layer JSON file")
    parser.add_argument(
        "--json",
        type=Path,
        default=THIS_DIR / "setup-layers.json",
        help="JSON file. Default is %(default)s",
    )
    parser.add_argument(
        "--top-dir",
        type=Path,
        default=Path.cwd(),
        help="Top level directory. Default is CWD",
    )

    args = parser.parse_args()

    with args.json.open("r") as f:
        data = json.load(f)

    errors = 0
    for name, layer in data["sources"].items():
        branch = layer["git-remote"]["branch"]
        rev = layer["git-remote"]["rev"]
        p = subprocess.run(
            [
                "git",
                "-C",
                args.top_dir / layer["path"],
                "merge-base",
                "--is-ancestor",
                rev,
                f"origin/{branch}",
            ]
        )
        if p.returncode != 0:
            print(f"ERROR: {name}: {branch} does not contain {rev}")
            errors += 1

    if errors:
        print(f"Found {errors} error")
        return 1

    print("Everything looks OK")
    return 0


if __name__ == "__main__":
    sys.exit(main())
