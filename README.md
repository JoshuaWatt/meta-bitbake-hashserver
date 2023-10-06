# meta-bitbake-hashserver
Meta layer for building the bitbake hash equivalence server container images

## Quick start

Pre-built images for the hash equivalence server are published
[here](https://github.com/JoshuaWatt/meta-bitbake-hashserver/pkgs/container/bitbake-hashserver)
and can be pulled from there using your favorite container management tool.

## Building from Source

This layer provides support for downloading dependent layers using the
`setup-layers` script. To download this layer and all dependent layers run:

```shell
git clone https://github.com/JoshuaWatt/meta-bitbake-hashserver.git
./meta-bitbake-hashserver/script/setup-layers
```

The layer also provided template files which can be used to initialize the
environment. To use them run:

```shell
TEMPLATECONF=$(pwd)/meta-bitbake-hashserver/conf/templates/bitbake-hashserver/ . ./core/oe-init-build-env
```
**NOTE** This only works with a new build environment. If you have already
initialized the environment, it will not do anything

Finally, the hash equivalence server container image can be built with

```shell
bitbake bitbake-hashserver-container-image
```

After building, the image imported into `podman` using:

```shell
podman load -i tmp-glibc/deploy/images/qemux86-64/bitbake-hashserver-container-image-qemux86-64.rootfs-*.rootfs-oci.tar
```

Finally, the image can be executed using:

```shell
podman run --rm -it localhost/bitbake-hashserver-container-image:latest
```


## Testing

This layer provides a test image that can be used to run the bitbake selftest
for the hash equivalence server in a generated image. In order to build the
test image, you must enable PTEST support for the `bitbake-hashserver` recipe
by adding the following to your `local.conf`:

```
PTEST_ENABLED:pn-bitbake-hashserver = "1"
```

The test image can be built and tested using the following commands:

```shell
bitbake bitbake-hashserver-test-container-image
podman load -i tmp-glibc/deploy/images/qemux86-64/bitbake-hashserver-test-container-image-qemux86-64.rootfs-*.rootfs-oci.tar
podman run --rm -it localhost/bitbake-hashserver-test-container-image:latest
```

## Submitting patches

To submit patches for this layer, please open a
[Pull Request](https://github.com/JoshuaWatt/meta-bitbake-hashserver/pulls)


## Maintainers

This layer is maintained by [Joshua Watt](https://github.com/JoshuaWatt/)
[Joshua.Watt@garmin.com](mailto:Joshua.Wat@garmin.com)
