def call(String project, String image){
     withCredentials([usernamePassword(
       credentialsId: "dockerHubCreds",
       passwordVariable: "dockerHubPass",
       usernameVariable: "dockerHubUser"
       )]){
           sh "docker login -u  ${env.dockerHubUser} -p ${env.dockerHubPass}"
           sh "docker image tag ${image} ${env.dockerHubUser}/${project}:latest"
           sh "docker push ${env.dockerHubUser}/${project}:latest"
     }
}
