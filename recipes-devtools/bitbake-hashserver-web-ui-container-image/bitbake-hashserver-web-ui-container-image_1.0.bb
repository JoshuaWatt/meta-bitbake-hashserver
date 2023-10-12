SUMMARY = "Hash Equivalence Server Container Image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_FSTYPES = "container oci"
OCI_IMAGE_ENTRYPOINT = "gunicorn"
OCI_IMAGE_ENTRYPOINT_ARGS = "bitbake_hashserver_web_ui:wsgi"
OCI_IMAGE_TAG = "${IMAGE_BASENAME}:latest"
OCI_IMAGE_AUTHOR = "Joshua Watt"
OCI_IMAGE_AUTHOR_EMAIL = "Joshua.Watt@garmin.com"
OCI_IMAGE_PORTS = "8000"

inherit image
inherit image-oci

IMAGE_FEATURES = ""
IMAGE_LINGUAS = ""
NO_RECOMMENDATIONS = "1"

IMAGE_INSTALL = "\
    busybox \
    bitbake-hashserver-web-ui \
    python3-gunicorn \
    "
