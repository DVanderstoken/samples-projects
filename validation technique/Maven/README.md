## Maven

Les questions ici présentes pourront être enrichies des <a href="https://github.com/Ebazhanov/linkedin-skill-assessments-quizzes/blob/master/maven/maven-quiz.md">questions utilisées sur LinkedIn</a>.

### Quelles sont les phases du cycle de vie Maven par défaut ?

**Réponse attendue** :
  - **validate**
  - initialize
  - generate-sources
  - process-sources
  - generate-resources
  - process-resources
  - **compile**
  - process-classes
  - generate-test-sources
  - process-test-sources
  - generate-test-resources
  - process-test-resources
  - test-compile
  - process-test-classes
  - **test**
  - prepare-package
  - **package**
  - pre-integration-test
  - integration-test
  - post-integration-test
  - **verify**
  - **install**
  - **deploy**

### Quel est le format de packaging par défaut ?

**Réponse attendue** :

jar

### Quels formats de packaging sont pris en charge par Maven :
- [ ] ear
- [ ] ejb
- [ ] ejb3
- [ ] par
- [ ] pom
- [ ] rar
- [ ] war
- [x] Toutes les réponses ci-dessus sont des bonnes réponses


### Qu'est-ce qu'un *Archetype* au sens Maven du terme ?

**Réponse attendue** :

Un Archetype Maven est un modèle de projet. L'invocation de la commande `mvn archetype:generate...` crée le projet en fonction du modèle utilisé :
```shell
    mvn archetype:generate                                  \
      -DarchetypeGroupId=<archetype-groupId>                \
      -DarchetypeArtifactId=<archetype-artifactId>          \
      -DarchetypeVersion=<archetype-version>                \
      -DgroupId=<my.groupid>                                \
      -DartifactId=<my-artifactId>
```
