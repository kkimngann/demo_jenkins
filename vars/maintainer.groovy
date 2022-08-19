#!groovy
import se.diabol.jenkins.pipeline.lib.Constants
import se.diabol.jenkins.pipeline.lib.Shell

def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    def shell = new Shell(this)

    pipeline {
        agent any

         stages {
             stage('Checkout') {
                 steps {
                     script {
                         println(config.maintainer)
                         println(config.platform)
                         shell.execute('sudo pip3 install -r requirements.txt')
                     }

                 }
             }

              stage('Test') {
                 steps {
                     script {
                         shell.execute('pytest --html=log.html Steps_define/test_login.py -s')
                     }
                 }
             }
         }
    }
}