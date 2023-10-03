DESCRIPTION = "aiosqlite provides a friendly, async interface to sqlite databases."
HOMEPAGE = "https://github.com/omnilib/aiosqlite"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f0c422eaa1f23d09f8203dc0af3e2d54"

SRC_URI[sha256sum] = "95ee77b91c8d2808bd08a59fbebf66270e9090c3d92ffbf260dc0db0b979577d"

PYPI_PACKAGE = "aiosqlite"
inherit pypi python_flit_core

RDEPENDS:${PN} += "\
    python3-asyncio \
    python3-core \
"

BBCLASSEXTEND = "native nativesdk"
