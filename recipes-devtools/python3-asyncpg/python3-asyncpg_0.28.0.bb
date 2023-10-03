DESCRIPTION = "Database interface library designed specifically for PostgreSQL \
and Python/asyncio. asyncpg is an efficient, clean implementation of PostgreSQL \
server binary protocol for use with Python’s asyncio framework."
HOMEPAGE = "https://github.com/MagicStack/asyncpg"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=813b34b25fe7db380a4467c87e5728c9"

SRC_URI[sha256sum] = "7252cdc3acb2f52feaa3664280d3bcd78a46bd6c10bfd681acfffefa1120e278"

PYPI_PACKAGE = "asyncpg"
inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-asyncio \
    python3-core \
"

BBCLASSEXTEND = "native nativesdk"
