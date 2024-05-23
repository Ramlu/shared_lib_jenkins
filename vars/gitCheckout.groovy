def call(Map stageParams){

    // checkout([
    //     $class: 'GitSCM',
    //     branches: [[ name: stageParams.branch ]],
    //     //userRemoteConfigs: [[ url: stageParams.url ]]

    //      userRemoteConfigs: [[
    //         url: stageParams.url,
    //         credentialsId: stageParams.credentialsId
    //     ]]
    // ])
    Map userremoteConfig = [url: stageParams.url]
    
    if (stageParams.credentialsId) {
        userremoteConfig.credentialsId = stageParams.credentialsId
    }
    
    checkout([
        $class: 'GitSCM',
        branches: [[name: stageParams.branch]],
        userRemoteConfigs: [userremoteConfig]
    ])

}