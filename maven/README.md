## Intégrer le wrapper maven à un projet : 

A partir de la racine du projet, exécuter la commande :
```
mvn -N io.takari:maven:0.7.6:wrapper [-Dmaven={version}]
```

## Exécuter les tests dans des JVM différentes :

```
<project>
    (...)
    </build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M5</version>
                <configuration>
                    <forkCount>5</forkCount>
                    <reuseForks>false</reuseForks>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```