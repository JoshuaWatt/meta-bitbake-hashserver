DESCRIPTION = "aiomysql is a 'driver' for accessing a MySQL database from the asyncio"
HOMEPAGE = "https://github.com/aio-libs/aiomysql"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=528175c84163bb800d23ad835c7fa0fc"

SRC_URI[sha256sum] = "558b9c26d580d08b8c5fd1be23c5231ce3aeff2dadad989540fee740253deb67"

SRC_URI += "file://0001-Revert-pin-setuptools_scm-7-due-to-broken-builds-810.patch"

DEPENDS += "python3-setuptools-scm-native python3-setuptools-scm-git-archive-native"

PYPI_PACKAGE = "aiomysql"
inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "\
    python3-asyncio \
    python3-core \
"

BBCLASSEXTEND = "native nativesdk"
