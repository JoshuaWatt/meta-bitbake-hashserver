require bitbake-hashserver-container-image.inc
SUMMARY = "Hash Equivalence Server Test Container Image"

IMAGE_INSTALL:append = " bitbake-hashserver-ptest ptest-runner"

OCI_IMAGE_ENTRYPOINT = "${bindir}/ptest-runner"
