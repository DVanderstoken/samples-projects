## Spring bean scopes

### Quels sont les différents 'scopes' possible pour un 'Bean Spring' ?



**Réponse attendue** :
- **singleton**,
- **prototype**, et
- dans un contexte Web :
  - **request**, 
  - **session**,
  - **application**,
  - **globalSession**, et
  - **websocket**

**Explications** :

Les beans Spring sont déclarés explicitement à l'aide de l'annotation *@Bean*.

Un bean de type **singleton**, type par défaut, est caractérisé par une instance unique partagée par l'ensemble de l'application. Il est instancié par défaut lors du démarrage du container Spring. Son instanciation peut être décalée au premier appel à l'aide de l'annotation *@Lazy*. Un bean *singleton* est donc partagé entre les différents composants et doit être utilisé pour des objets dits *'stateless'*.

Un bean de type **prototype**, doit être déclaré explicitement de ce type avec l'annotation *@Scope("prorotype")*. Une nouvelle instance sera créée à chaque nouvelle injection dudit bean. Son utilisation est recommandée pour les objets dits *'statefull'*.

Les autres *'scopes'* sont utilisés uniquement dans des applications Web :
- **request** : une instance créée par requête HTTP,
- **session** : une instance créée par session HTTP,
- **application** : une instance créée par *'ServletContext'*,
- **globalSession** : concerne les *'Portlets'*, équivalent à *'session'* hors Portlet,
- **websocket** : une instance pas session *'WebSocket*'

