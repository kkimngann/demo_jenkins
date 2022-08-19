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
                     }

                 }
             }
             stage('Build') {
                 steps {
                     script {
                         echo 'Build'
                     }
                 }
             }

              stage('Test') {
                 steps {
                     script {
                        echo 'Test'
                     }
                 }
             }
         }
    }
}