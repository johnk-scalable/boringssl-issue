FROM azul/zulu-openjdk-alpine:17-jre

ENV JARFILE boringssl-issue-0.0.1-SNAPSHOT.jar

COPY ./target/$JARFILE .

CMD java -jar ${JARFILE}