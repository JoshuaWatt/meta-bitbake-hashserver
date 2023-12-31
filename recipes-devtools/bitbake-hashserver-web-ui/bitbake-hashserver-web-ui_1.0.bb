SUMMARY = "Web UI for the bitbake hash server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

DEPENDS = ""

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "git://github.com/JoshuaWatt/bitbake-hashserver-web-ui.git;protocol=https;branch=${BRANCH}"
BRANCH = "main"
SRCREV = "084f1198d71873db95cf8d1935664dcb8f59468d"

S = "${WORKDIR}/git"

inherit python_hatchling

RDEPENDS:${PN} += "\
    bitbake-hashserver \
    python3-flask \
    python3-modules \
"
