def gitlabServer = '192.168.10.195'

node('docker-agent2') {
    timestamps {
        try {
            stage('SCM') {
                git branch: "master", url: "git@github.com:dzottola/AutoZ.git"
            }

            stage('Docker Process') {
                sh "docker run -d --name node32767 -P -p 32767:5900 --link selenium-hub:hub selenium/node-chrome-debug"
            }


            stage('Build & Test') {

                try {
                    sh "mvn clean compile test -X -e -P${env.MVN_Profile} -Denvironment=${env.Environment} -DTestrailRunID=${env.TestRailRunID} -DRemoteWebDriver=${RemoteWebDriver}"
                } finally {
                    publishHTML([allowMissing: true, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'ExtentReport\\', reportFiles: 'Testing.html', reportName: 'HTML Report', reportTitles: ''])
                }
            }

        } finally {

            sh "docker stop 32767"
            cleanWs notFailBuild: false
        }
    }
}
