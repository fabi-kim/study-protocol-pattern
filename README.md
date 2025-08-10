## protocol-pattern 스터디
* 디자인 패턴 적용 v0.1
  * 스트레티지 패턴 Staking, Unstking 행동을 분리하여 위임

```mermaid
classDiagram
    class Protocol{
        <<abstract>>
    }
    class CosmosProtocol
    class AtomProtocol
    class TrxProtocol

    class Staking {
        <<interface>>
    }
    class CosmosStaking
    class AtomStaking
    class TrxStaking
    class SuiStaking

    class Unstaking {
        <<interface>>
    }
    class CosmosUnstaking
    class AtomUnstaking
    class TrxUnstaking
    class SuiUnstaking

    Protocol <|-- CosmosProtocol
    Protocol <|-- TrxProtocol
    CosmosProtocol <|-- AtomProtocol
    
    Staking <|.. CosmosStaking
    Staking <|.. AtomStaking
    Staking <|.. TrxStaking
    Staking <|.. SuiStaking

    CosmosStaking <|-- AtomStaking

    Unstaking <|.. CosmosUnstaking
    Unstaking <|.. AtomUnstaking
    Unstaking <|.. TrxUnstaking
    Unstaking <|.. SuiUnstaking
  
    CosmosUnstaking <|-- AtomUnstaking
    

    Protocol --> Staking
    Protocol --> Unstaking
```

* 디자인 패턴 적용 v0.2
  * Observer 패턴으로 블록 조회, 파싱 로직 분리
  * !! 블록 조회 입출금 파싱에 사용하려고 했지만 하나의 subject에 하나의 Observer가 결합되는 일대일 구조여서 우선 필요없을듯
```mermaid
classDiagram

%% ===== dto =====
class Block
<<interface>> Block
class EvmBlock
EvmBlock ..|> Block

%% ===== protocol core =====
class BlockParser
<<interface>> BlockParser
class Protocol
class KaiaProtocol


KaiaProtocol --|> Protocol
KaiaProtocol ..|> BlockParser



%% ===== pubsub =====
class Subject
<<interface>> Subject
class BlockSubject
BlockSubject ..|> Subject

class Observer
<<interface>> Observer
class BlockObserver
BlockObserver ..|> Observer

%% ===== associations =====
BlockObserver --> BlockParser : uses
BlockObserver --> Block : parses
BlockSubject o-- Observer : observers
BlockSubject --> Block : emits
```