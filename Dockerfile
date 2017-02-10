FROM tomcat:7-jre7
MAINTAINER jay.pan@infinitus-int.com
RUN rm -rvf /usr/local/tomcat/webapps/ROOT
ADD  target/saas-sample-web-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080