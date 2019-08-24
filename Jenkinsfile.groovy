node { 
    stage("pull repo"){
       properties([parameters([string(defaultValue: '52.14.177.159', description: '''Dev:52.14.177.159
QA:18.188.242.117
Prod:3.15.200.213''', name: 'Remote_instances', trim: false)])])
       git 'https://github.com/jipara/jenkins-april.git'
    }
    stage("Install Apache"){
        sh "ssh ec2-user@${Remote_instances}  sudo yum install httpd -y"
    }
    stage("Create Index.html"){
        sh "scp index.html ec2-user@${Remote_instances}:/tmp"
    }
    stage("Move Files"){
        sh "ssh ec2-user@${Remote_instances}  sudo mv /tmp/index.html /var/www/html/index.html"
    }
    stage("Restart httpd"){
        sh "shh ec2-user@${Remote_instances"} sudo systemctl restart httpd"
    }
}