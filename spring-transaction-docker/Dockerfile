FROM open-liberty:full-java8-openj9

USER root
# make is for snapit
# porcps-ng is for vmstat, ps, top (in linperf.sh)
# net-tools is for netstat (in inperf.sh)
# gdb is for gcore
# RUN dnf install -y make procps-ng net-tools gdb
COPY --chown=1001:0 config/server.xml /config/
COPY --chown=1001:0 config/jvm.options /config/
COPY --chown=1001:0 apps/spring.transaction.war /config/apps/

USER 1001
