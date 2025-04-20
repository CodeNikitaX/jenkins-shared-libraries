def call(String credId, String project, String image){
     withCredentials([usernamePassword(
       credentialsId: "${credId}",
       passwordVariable: "dockerHubPass",
       usernameVariable: "dockerHubUser"
       )]){
           sh "docker login -u  ${env.dockerHubUser} -p ${env.dockerHubPass}"
           sh "docker image tag ${image} ${env.dockerHubUser}/${project}:latest"
           sh "docker push ${env.dockerHubUser}/${project}:latest"
     }
}
