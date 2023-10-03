SUMMARY = "Bitbake Hash Equivalence Server"
HOMEPAGE = "https://git.openembedded.org/bitbake"
LICENSE = "GPL-2.0-only & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7e4cfe1c8dee5c6fe34c79c38d7b6b52"
DEPENDS = ""

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "git://git.openembedded.org/bitbake;protocol=https;branch=${BRANCH} \
           file://run-ptest \
           "
BRANCH = "2.4"
SRCREV = "08033b63ae442c774bd3fce62844eac23e6882d7"

S = "${WORKDIR}/git"

inherit allarch
inherit ptest

do_install() {
    DEST="${D}${datadir}/${BPN}"

    install -Dm 0755 ${S}/bin/bitbake-hashserv $DEST/bin/bitbake-hashserv
    cp --no-preserve=ownership -r ${S}/lib $DEST/

    # Remove toaster (QA errors)
    rm -rf $DEST/lib/toaster
}

do_install_ptest() {
    DEST="${D}${datadir}/${BPN}"

    install -Dm 0755 ${S}/bin/bitbake-selftest $DEST/bin/bitbake-selftest

	sed -i \
        -e "s#@datadir@#${datadir}#g" \
        -e "s#@BPN@#${BPN}#g" \
        ${D}${PTEST_PATH}/run-ptest
}

SQLALCHEMY_RDEPENDS = "\
    python3-sqlalchemy \
    python3-aiosqlite \
    python3-asyncpg \
    python3-aiomysql \
    python3-greenlet \
"

RDEPENDS:${PN} += "\
    python3-modules \
    python3-websockets \
    ${SQLALCHEMY_RDEPENDS} \
"
