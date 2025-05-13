# Building PicassoCode from source code

## Toolchain
1. Java 21+ (GraalVM JDK 21+ is highly recommened as the application is also built natively)
2. Maven (you should be able to run `mvn` on your terminal

### Verify the correct toolchain

On my machine I have:
```sh
$ java --version

java 24 2025-03-18
Java(TM) SE Runtime Environment Oracle GraalVM 24+36.1 (build 24+36-jvmci-b01)
Java HotSpot(TM) 64-Bit Server VM Oracle GraalVM 24+36.1 (build 24+36-jvmci-b01, mixed mode, sharing)

mvn --version

Apache Maven 3.9.9 (8e8579a9e76f7d015ee5ec7bfcdc97d260186937)
Maven home: /usr/share/java/maven
Java version: 24, vendor: Oracle Corporation, runtime: /home/hexaredecimal/.local/bin/graalvm-jdk-24+36.1
Default locale: en_ZA, platform encoding: UTF-8
OS name: "linux", version: "6.14.2-arch1-1", arch: "amd64", family: "unix"
```

## Build Process

##### Follow the steps bwlow to compile the project.

1. Clone the repo if you haven't.
```sh
$ git clone git@github.com:Glimmr-Lang/PicassoCode.git
```

2. Enter the directory and build.
```sh
$ cd PicassoCode
$ mvn install -U
$ mvn package
```

If the build went correctly there should be two jar files inside the `target` folder created my maven, if not please open an issue 
and I will swiftly take a look.

