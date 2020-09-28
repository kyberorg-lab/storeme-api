@Library('common-lib@1.6.1') _
pipeline {
  agent any;
  environment {
    DOCKER_REPO = 'yadev/storeme-api'
  }
  parameters {
    string(name: 'DOCKER_TAG', defaultValue: "")
    booleanParam(name: 'PRODUCTION_BUILD', defaultValue: false, description: 'Deploy to Production')
  }
  stages {
    stage('Docker') {
      steps {
        script {
          def dockerTag = params.DOCKER_TAG;
          if (dockerTag.trim().equals("")) {
            dockerTag = env.BRANCH_NAME;
          }

          def tags = [];
          tags << dockerTag;

          dockerBuild(repo: env.DOCKER_REPO, tags: tags);
          dockerLogin(creds: 'hub-docker');
          dockerPush();
          dockerLogout();
          dockerClean();
        }
      }
    }
    stage('Deploy to Dev K8S') {
      when {
        not {
          anyOf {
            branch 'master'
            buildingTag()
            expression {
              return params.PRODUCTION_BUILD
            }
          }
        }

      }
      steps {
        script {
          deployToKube(
                  namespace: 'dev-storeme',
                  workloadName: 'storeme-api',
                  imageRepo: env.DOCKER_REPO,
                  imageTag: env.BRANCH_NAME,
                  containerName: 'api'
          )
        }
      }
    }
    stage('Deploy to Prod K8S') {
      when {
        anyOf {
          branch 'master'
          buildingTag()
          expression {
            return params.PRODUCTION_BUILD
          }
        }
      }
      steps {
        script {
          deployToKube(
                  namespace: 'prod-storeme',
                  workloadName: 'storeme-api',
                  imageRepo: env.DOCKER_REPO,
                  imageTag: env.BRANCH_NAME,
                  containerName: 'api'
          )
        }
      }
    }
  }
  post {
    always {
      cleanWs();
    }
  }
}
