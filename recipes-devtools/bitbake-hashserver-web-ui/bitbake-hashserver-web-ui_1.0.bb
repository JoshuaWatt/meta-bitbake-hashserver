SUMMARY = "Web UI for the bitbake hash server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

DEPENDS = ""

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "git://github.com/JoshuaWatt/bitbake-hashserver-web-ui.git;protocol=https;branch=${BRANCH}"
BRANCH = "main"
SRCREV = "d6c252660994a918d82a25060e88800153b283e8"

S = "${WORKDIR}/git"

do_compile() {
    :
}

do_install() {
    cd ${S}
    oe_runmake install \
        prefix=${prefix} \
        datadir=${datadir} \
        DESTDIR=${D}
}

RDEPENDS:${PN} += "\
    bitbake-hashserver \
    python3-flask \
    python3-modules \
"
