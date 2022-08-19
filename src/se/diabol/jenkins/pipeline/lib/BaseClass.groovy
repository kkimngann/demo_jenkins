package se.diabol.jenkins.pipeline.lib

class BaseClass implements Serializable{
    Object jenkinsContext
    BaseClass(jenkinsContext){
        this.jenkinsContext = jenkinsContext
    }
}
