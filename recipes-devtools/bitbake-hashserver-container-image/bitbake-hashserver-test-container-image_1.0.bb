require bitbake-hashserver-container-image.inc

IMAGE_INSTALL:append = " bitbake-hashserver-ptest ptest-runner"

OCI_IMAGE_ENTRYPOINT = "${bindir}/ptest-runner"
