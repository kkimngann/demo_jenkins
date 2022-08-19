package se.diabol.jenkins.pipeline.lib

class Shell extends BaseClass{
    Shell(Object jenkinsContext) {
        super(jenkinsContext)
    }

    void execute(String command){
        jenkinsContext.sh command
    }
}
