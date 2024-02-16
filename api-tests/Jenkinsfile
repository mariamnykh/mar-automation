// Report variables
def reportDir = "api-tests/build/reports/tests/test"
def reportFile = "index.html"
def reportName = "Test Report"

pipeline{
	agent any
	    stages {
            stage("Execute tests") {
                steps {
                    script {
                        sh '''
                            ./gradlew :api-tests:clean :api-tests:test \
                            -Dsmoke="${SMOKE}" \
                            -Duser="${USER}" \
                            -Dpet="${PET}"
                        '''
                    }
                }
            }
        }
	post {
        always {
            script{
               publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true,
                                reportDir: reportDir, reportFiles: reportFile, reportName: reportName])
            }
        }
    }
}