SUMMARY = "Hash Equivalence Client Container Image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FSTYPES = "container oci"
OCI_IMAGE_ENTRYPOINT = "${datadir}/bitbake-hashserver/bin/bitbake-hashclient"
OCI_IMAGE_TAG = "${IMAGE_BASENAME}:latest"
OCI_IMAGE_AUTHOR = "Joshua Watt"
OCI_IMAGE_AUTHOR_EMAIL = "Joshua.Watt@garmin.com"

inherit image
inherit image-oci

IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""
NO_RECOMMENDATIONS = "1"

IMAGE_INSTALL = "busybox bitbake-hashserver"
