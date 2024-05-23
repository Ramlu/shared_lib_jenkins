def call(Map stageParams){

    checkout([
        $class: 'GitSCM',
        braches: [[name: 'stageParams.branch']],
        userRemoteConfigs: [[ url: stageParams.url ]]
    ])
}