package com.gustavovieira.memorialdacriacao.data

data class ScriptureMatchPair(
    val conceptTitle: String,
    val conceptBody: String,
    val bibleTitle: String,
    val bibleBody: String
)

object GameData {
    val creationPairs = listOf(
        ScriptureMatchPair(
            conceptTitle = "IMAGO DEI",
            conceptBody = "O ser humano foi criado para refletir o caráter, o amor e o governo de Deus na Terra, vivendo em relacionamento com Ele e com a criação.",
            bibleTitle = "Gênesis 1:26-27",
            bibleBody = "\"Façamos o homem à nossa imagem, conforme a nossa semelhança...\""
        ),
        ScriptureMatchPair(
            conceptTitle = "FÔLEGO DIVINO",
            conceptBody = "A vida humana não pertence ao próprio ser humano; ela existe porque Deus compartilha Seu fôlego e sustenta continuamente Sua criação.",
            bibleTitle = "Gênesis 2:7",
            bibleBody = "\"E soprou em suas narinas o fôlego de vida.\""
        ),
        ScriptureMatchPair(
            conceptTitle = "DOMÍNIO BENEVOLENTE",
            conceptBody = "Deus entregou ao ser humano a responsabilidade de governar a criação com cuidado, bondade e proteção, nunca com destruição.",
            bibleTitle = "Gênesis 1:28",
            bibleBody = "\"Dominai sobre toda a terra...\""
        ),
        ScriptureMatchPair(
            conceptTitle = "LIBERDADE DE ESCOLHA",
            conceptBody = "Deus não força obediência, pois o verdadeiro amor só pode existir quando há liberdade para escolher entre confiar ou rejeitar Sua vontade.",
            bibleTitle = "Gênesis 2:16-17",
            bibleBody = "\"De toda árvore comerás livremente...\""
        ),
        ScriptureMatchPair(
            conceptTitle = "UMA SÓ CARNE",
            conceptBody = "Homem e mulher foram criados para viver em unidade, parceria e mutualidade, refletindo relacionamentos de amor e fidelidade.",
            bibleTitle = "Gênesis 2:24",
            bibleBody = "\"E serão ambos uma só carne.\""
        ),
        ScriptureMatchPair(
            conceptTitle = "DIGNIDADE HUMANA",
            conceptBody = "Entre todas as criaturas terrestres, o ser humano recebeu honra especial por carregar a imagem de Deus e representar Seu reino.",
            bibleTitle = "Salmos 8:5",
            bibleBody = "\"De glória e honra o coroaste.\""
        ),
        ScriptureMatchPair(
            conceptTitle = "MEMORIAL DA CRIAÇÃO",
            conceptBody = "O sábado relembra que Deus é o Criador, Senhor do tempo e da vida, e que o ser humano encontra descanso e propósito nEle.",
            bibleTitle = "Gênesis 2:2-3",
            bibleBody = "\"E abençoou Deus o dia sétimo.\""
        ),
        ScriptureMatchPair(
            conceptTitle = "VIDA EM DEUS",
            conceptBody = "A vida eterna não é independente de Deus; ela existe somente através da comunhão contínua com o Criador.",
            bibleTitle = "Gênesis 3:22",
            bibleBody = "\"Para que não tome também da árvore da vida...\""
        ),
        ScriptureMatchPair(
            conceptTitle = "GUARDIÃO DA CRIAÇÃO",
            conceptBody = "O ser humano foi chamado não apenas para governar, mas também para cultivar, proteger e preservar aquilo que pertence a Deus.",
            bibleTitle = "Gênesis 2:15",
            bibleBody = "\"O Senhor Deus o colocou no jardim para o cultivar e guardar.\""
        ),
        ScriptureMatchPair(
            conceptTitle = "VIDA COMO DOM",
            conceptBody = "A existência humana não é autossuficiente; tudo o que o ser humano possui vem do Criador e depende dEle.",
            bibleTitle = "Atos 17:28",
            bibleBody = "\"Pois nele vivemos, nos movemos e existimos.\""
        ),
    )
}