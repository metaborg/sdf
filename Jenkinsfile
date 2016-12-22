properties([
  pipelineTriggers([
    upstream(
      threshold: hudson.model.Result.SUCCESS,
      upstreamProjects: '/metaborg/spoofax-releng/master'
    )
  ])
])

node{
    stage 'Build and Test'
    checkout scm
    sh "git clean -fXd" // make sure generated files are removed (git-ignored files). Use "-fxd" to also remove untracked files, but note that this will also remove .repository forcing mvn to download all artifacts each build
    withMaven(
      mavenLocalRepo: '.repository',
      mavenOpts: '-Xmx1024m -Xss16m'
    ){
      // Run the maven build
      sh "mvn -B -U clean verify -DforceContextQualifier=\$(date +%Y%m%d%H%M) "
    }
    archiveArtifacts artifacts: 'org.metaborg.meta.lang.template.eclipse.site/target/site/', excludes: null, onlyIfSuccessful: true
}
