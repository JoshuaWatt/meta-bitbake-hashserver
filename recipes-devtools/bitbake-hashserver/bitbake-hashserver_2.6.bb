SUMMARY = "Bitbake Hash Equivalence Server"
HOMEPAGE = "https://git.openembedded.org/bitbake"
LICENSE = "GPL-2.0-only & MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7e4cfe1c8dee5c6fe34c79c38d7b6b52"
DEPENDS = ""

INHIBIT_DEFAULT_DEPS = "1"

SRC_URI = "git://git.openembedded.org/bitbake;protocol=https;branch=${BRANCH} \
           file://run-ptest \
           file://0001-hashserv-Add-remove-API.patch \
           file://0002-bitbake-hashclient-Add-remove-subcommand.patch \
           file://0003-hashserv-Extend-get_outhash-API-to-optionally-includ.patch \
           file://0004-hashserv-Add-API-to-clean-unused-entries.patch \
           file://0005-bitbake-hashclient-Add-clean-unused-subcommand.patch \
           file://0006-asyncrpc-Abstract-sockets.patch \
           file://0007-hashserv-Add-websocket-connection-implementation.patch \
           file://0008-asyncrpc-Add-context-manager-API.patch \
           file://0009-hashserv-tests-Add-external-database-tests.patch \
           file://0010-asyncrpc-Prefix-log-messages-with-client-info.patch \
           file://0011-bitbake-hashserv-Allow-arguments-from-environment.patch \
           file://0012-hashserv-Abstract-database.patch \
           file://0013-hashserv-Add-SQLalchemy-backend.patch \
           file://0014-contrib-Update-hashserv-Dockerfile.patch \
           file://0015-contrib-hashserv-Add-docker-compose.patch \
           file://0016-hashserv-Implement-read-only-version-of-report-RPC.patch \
           "
BRANCH = "2.6"
SRCREV = "5a1e5b8dc55d6bb4d93bac3492f8c43ff957e712"

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
