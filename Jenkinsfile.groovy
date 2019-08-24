node { 
    stage("say hello"){
       properties([pipelineTriggers([cron('''* * * * *''')])])
        sh "echo hello ${NAME}",
        sh "do something"
    }
}