# Repo showing boringssl-issue
Segfault is thrown when using boringssl > 2.0.56.Final with SpringBoot 2.7.13 running on azul/zulu-openjdk-alpine:17-jre

## Reproduction

```
mvn clean install
docker build . -t demo
docker run demo
```

## Result
```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.13)

2023-07-05 09:12:35.330  INFO 1 --- [           main] c.e.b.BoringsslIssueApplicationKt        : Starting BoringsslIssueApplicationKt v0.0.1-SNAPSHOT using Java 17.0.7 on 58afe9a807c0 with PID 1 (/boringssl-issue-0.0.1-SNAPSHOT.jar started by root in /)
2023-07-05 09:12:35.338  INFO 1 --- [           main] c.e.b.BoringsslIssueApplicationKt        : No active profile set, falling back to 1 default profile: "default"
2023-07-05 09:12:36.199  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2023-07-05 09:12:36.206  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2023-07-05 09:12:36.206  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.76]
2023-07-05 09:12:36.259  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2023-07-05 09:12:36.260  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 878 ms
#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x00000000000226a0, pid=1, tid=7
#
# JRE version: OpenJDK Runtime Environment Zulu17.42+19-CA (17.0.7+7) (build 17.0.7+7-LTS)
# Java VM: OpenJDK 64-Bit Server VM Zulu17.42+19-CA (17.0.7+7-LTS, mixed mode, tiered, compressed oops, compressed class ptrs, g1 gc, linux-aarch64)
# Problematic frame:
# C  [libnetty_tcnative_linux_aarch_643628199650810350541.so+0x2330c]  init_have_lse_atomics+0xc
#
# Core dump will be written. Default location: //core
#
# An error report file with more information is saved as:
# //hs_err_pid1.log
#
# If you would like to submit a bug report, please visit:
#   http://www.azul.com/support/
# The crash happened outside the Java Virtual Machine in native code.
# See problematic frame for where to report the bug.
#
```
