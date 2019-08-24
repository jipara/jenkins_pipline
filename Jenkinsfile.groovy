node { 
    stage("say hello"){
       properties([parameters([string(defaultValue: 'Jipara', description: 'past your name', name: 'NAME', trim: true)]), pipelineTriggers([cron('* * * * *')])])
        sh "echo hello ${NAME}"
    }
}