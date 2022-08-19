#!groovy
import se.diabol.jenkins.pipeline.lib.Constants

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline {
        agent any

         stages {
             stage('Checkout') {
                 steps {
                     script {
                         println(config.maintainer)
                         println(config.platform)
                         this.sh 'sudo pip3 install -r requirements.txt'
                     }

                 }
             }

              stage('Test') {
                 steps {
                     script {
                        this.sh 'pytest --html=log.html Steps_define/test_login.py -s'
                     }
                 }
             }
         }
    }
}