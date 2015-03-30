-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 30-Mar-2015 às 18:49
-- Versão do servidor: 5.6.21
-- PHP Version: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `db_senacblog`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `comentarios`
--

CREATE TABLE IF NOT EXISTS `comentarios` (
`id` int(30) NOT NULL,
  `usuario` int(10) NOT NULL,
  `post` int(10) NOT NULL,
  `comentario` longtext NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `posts`
--

CREATE TABLE IF NOT EXISTS `posts` (
`id` int(10) NOT NULL,
  `autor` int(10) NOT NULL,
  `titulo` varchar(120) NOT NULL,
  `conteudo` longtext NOT NULL,
  `data` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `posts`
--

INSERT INTO `posts` (`id`, `autor`, `titulo`, `conteudo`, `data`) VALUES
(7, 2, 'Artigo: A crise e a oportunidade', '<p>Por&nbsp;Walter Lídio Nunes, presidente da Celulose Riograndense</p>\r\n<p>O Brasil vive uma crise política, econômica e de valores. Diante disso, a sociedade demonstra uma reação consciente, indo às ruas para manifestar sua desconformidade. Essa situação pode representar um problema ou uma oportunidade, dependendo da forma como os atores políticos reagirão. A evolução do quadro pode ser de radicalização em favor do impeachment da presidente ou de mobilização das forças políticas e sociais numa ampla frente que discuta, de forma objetiva, reformas reestruturantes para o Brasil.</p>\r\n<p>O caminho de uma construção virtuosa passa por uma coalizão política genuinamente propositiva&nbsp;– não há espaço para ideologias partidárias anacrônicas que se sobreponham ao “grande partido” que é o Brasil. O governo, por sua vez, deve ser capaz de entender a crise com humildade e propor uma pauta amplamente convergente. Precisa evitar subterfúgios, como a descaracterização da mensagem das ruas como “movimentos da oposição”, “terceiro turno” ou “golpe”. Essa miopia política não constrói, apenas motivará a intensificação dessas manifestações.</p>\r\n<p>Também a oposição deve crescer no seu papel propositivo. A insatisfação popular tem muito a ver com a falta de respostas concretas e factíveis por parte das instituições máximas do país.</p>\r\n<p>Para os bem intencionados, esta é uma oportunidade rara de avançar com o apoio do povo. Basta que nossos governantes encarem o Brasil como o valor maior e que tenham uma postura de humildade ao responder àqueles que lhes outorgaram o poder. Negar ou tentar mistificar a crise é, seguramente, uma atitude que em nada contribui para o avanço do país.</p>\r\n<p><label class="labelLinkPublico">Fonte:</label> Zero Hora</p>', '2015-03-26 16:55:30'),
(8, 2, 'Celulose avança na cogeração e pode atingir 20 mil GWh até 2020', '<p>Até o fim da década, a geração de energia elétrica pela indústria de celulose poderá chegar a 20 mil gigawatts-hora (GWh) por ano, o dobro da capacidade de cogeração atual. Nesse cenário, os produtores brasileiros da fibra terão excedente total de energia para venda à rede externa da ordem de 6,5 mil GWh/ano, o suficiente para atender à demanda de uma cidade com 2,5 milhões de habitantes, segundo estudo da finlandesa Pöyry, que atua na área de consultoria e serviços de engenharia e é tradicional fornecedora da indústria globalmente.</p>\r\n<p>“À medida que cresce o tamanho das fábricas aumenta também a oportunidade em energia, porque é maior o potencial de cogeração”, explicou ao Valor o vice-residente da Pöyry, Carlos Farinha e Silva. Conforme o especialista, uma linha com capacidade produtiva de 1,5 milhão de toneladas anuais de celulose pode gerar até 270 MW, ou 2.300 GWh por ano, com excedente de 1.200 GWh por ano para comercialização. Atualmente, as maiores e mais modernas linhas de celulose em operação no mundo, que têm justamente esse tamanho, estão instaladas no Brasil e pertencem à Eldorado Brasil e à Suzano Papel e Celulose.</p>\r\n<p>O estudo da Pöyry mostra que a capacidade de geração de energia elétrica das indústrias brasileiras de papel e celulose é de 10 mil GWh/ano hoje em dia. Com a entrada em operação de seis novos projetos – da CMPC&nbsp;Celulose Riograndense&nbsp;(expansão de Guaíba), Fibria (Três Lagoas II), Eldorado (Três Lagoas II), Lwarcel (expansão) e da CRPE Holding (nova fábrica) -, a capacidade de cogeração dobraria, para 20 mil GWh.</p>\r\n<p>Assumindo-se um excedente de 15% na geração atual e de 50% da geração adicional futura, aponta a consultoria, haveria um excedente de 6,5 mil GWh ao ano que poderia se converter em receita ao setor de celulose. Um dos obstáculos da indústria, todavia, é o limite para venda subsidiada de energia à rede, de 30 MW, que acaba desestimulando mais investimentos em cogeração.</p>\r\n<p>“Há uma grande incerteza quando ao desenvolvimento da situação [energética] no Brasil, que é muito dependente da geração hídrica”, afirmou o vice-presidente da Pöyry. Ao mesmo tempo, ressalta, a biomassa ainda é subutilizada. “E ela vem como um subproduto da produção de celulose, o que é o melhor dos mundos”, ressaltou.</p>\r\n<p>A grande “usina” de energia das produtoras de celulose é a caldeira de recuperação química, cujo tamanho acompanhou o ganho de escala das linhas produtivas da fibra. É na caldeira de recuperação que é gerado o vapor de alta pressão que, além de ser usado no processo produtivo como energia térmica, aciona turbinas acopladas a geradores de energia. Esse vapor resulta da queima do licor negro, um subproduto da produção de celulose, na caldeira de recuperação.</p>\r\n<p>Outra fonte de energia é a queima de resíduos gerados no transporte, na picagem e peneiragem da madeira na caldeira de biomassa, que gera vapor e alimenta turbogeradores. Além disso, o resíduo gerado no descascamento da madeira, galhos e pontas resultantes do corte da floresta pode ser usado como biomassa, explicou Yves Gerschkovitch, responsável pela área de geração de vapor e energia da Pöyry. “A fábrica de celulose já é intrinsecamente uma termelétrica”, afirmou.</p>\r\n<p>Para indústrias mais antigas e com elevado custo de produção, o negócio de energia renovável já se mostrou mais rentável do que a própria produção de celulose. Em setembro do ano passado, por exemplo, a espanhola Ence, uma das maiores produtoras de fibra de eucalipto da Europa, anunciou o encerramento da produção de celulose na fábrica de Huelva (Andaluzia), com transformação da unidade em “um avanço centro de geração de energia renovável.</p>\r\n<p>&nbsp;</p>\r\n<p class="pLinkPublico"><label class="labelLinkPublico">Fonte:</label> Valor Econômico</p>', '2015-03-26 16:58:40'),
(9, 2, 'Presidente da FIERGS recebe convite para Mérito Florestal', '<p style="text-align: center"><a href="http://www.ageflor.com.br/noticias/wp-content/uploads/2015/03/fiergs1.jpg"><img class="aligncenter wp-image-81 size-full" src="http://www.ageflor.com.br/noticias/wp-content/uploads/2015/03/fiergs1.jpg" alt="SONY DSC" width="800" height="532"></a></p>\r\n<p>O presidente da FIERGS, Heitor Muller, recebeu das mãos do coordenador do Comitê da Indústria de Base Florestal e Moveleira, Serafim Quissini, o convite para participação da 5ª Feira da Floresta, que acontecerá de 11 a 15 de maio de 2015 em Nova Prata. Ele recebeu ainda convite para participação da cerimônia de premiação Mérito Florestal AGEFLOR que será realizada na noite do dia 13 de maio. Quissini, que além de coordenar o COMBASE é presidente do Sindimadeira-RS, estava acompanhado do presidente do Sinpasul, Walter Rudi Christmann, do diretor-executivo da AGEFLOR, Jorge Heineck, e dos diretores da Futura Feiras, Nilvia Röhrig e Roque Justen.</p>', '2015-03-26 16:58:40'),
(10, 2, 'AGEFLOR participa de encontro com secretário da Agricultura', '<p><a href="http://www.ageflor.com.br/noticias/wp-content/uploads/2015/03/16840401446_24d472860d_z.jpg"><img class="aligncenter wp-image-87 size-full" src="http://www.ageflor.com.br/noticias/wp-content/uploads/2015/03/16840401446_24d472860d_z.jpg" alt="16840401446_24d472860d_z" width="640" height="427" /></a></p>\r\n<p>Os componentes do Comitê de Base Florestal e Moveleira da FIERGS &#8211; COMBASE estiveram em agenda com o Secretário de Agricultura e Pecuária, Ernani Polo, na manhã do dia 19 de março. A AGEFLOR se fez presente através de seu vice-presidente de Ações Estratégicas e Projetos Especiais Diogo Carlos Leuck e pela assessora técnica Margô Guadalupe Antonio. O secretário Ernani Polo estava acompanhado do deputado estadual, Sérgio Turra. Acompanharam o Coordenador do Comitê, Serafim Gabriel Quissini, Rudi Cristhmann e Alício Bottini pelo SINPASUL e o assessor técnico do Comitê, Rafael Ferreira. Acompanharam a reunião, pela SEAP, Eugene Chouenne da Defesa Vegetal, Rodrigo Rizzo, Coordenador das Câmaras Setoriais, Valesca Grazziotin, Secretária das Câmaras Setoriais e Fernando Groff, diretor do Departamento de Defesa Agropecuária.</p>\r\n<p>Os gargalos da silvicultura e o cenário atual do setor no Estado foram os principais temas tratados na reunião. Algumas soluções para os entraves também foram apresentadas. Serafim Quissini fez apresentação do Comitê e das ações que vem sendo empreendidas em prol do setor florestal. Rafael Ferreira entregou documento sobre o assunto, com síntese sobre o setor de base florestal, anexando um diagnóstico sobre o setor e a minuta do Projeto de Lei sobre Florestas Plantadas elaborada na Câmara Setorial da SEAPA.  Conforme o analista técnico do Comitê da FIERGS Rafael Ferreira, a silvicultura está em processo de desaquecimento desde 2008. “O Rio Grande do Sul perdeu cerca de 140 mil hectares de floresta plantada desde então, estamos à beira de um período de escassez de madeira”, alertou.</p>\r\n<p>Eugene Chouenne fez um resumo histórico sobre a situação das florestas plantadas na administração pública enfatizando a proposta do Projeto de Lei e de criação de um Instituto Florestal nos moldes de parceria público-privada e utilização do FUNDEFLOR. Relatou a situação das pragas florestais percevejo bronzeado em eucalipto e cascudo serrador da acácia negra.  Sérgio Turra lembrou que ainda assim, o setor é responsável por 4% do PIB estadual e emprega mais de 350 mil pessoas. “Precisamos implementar atitudes proativas, visando o desenvolvimento da silvicultura”, afirmou.</p>\r\n<p>O vice-presidente da AGEFLOR, Diogo Leuck, assegurou que um dos caminhos para reverter o atual cenário é a construção de um marco institucional para o setor. “Assim teríamos mecanismos de promoção e desenvolvimento da silvicultura”, relatou. A readequação das licenças ambientais para a produção de florestas também é apontada como fundamental. “O Rio Grande do Sul é o único estado que mantém um nível altamente burocrático e complexo”, lembrou Leuck. Ele entregou ao Secretário um relatório sobre o ataque do cascudo serrador na acácia negra. Foi decidido que serão abertos novos processos para solicitação de decreto emergencial, ficando a cargo da AGEFLOR encaminhar as solicitações. O Secretário Ernani Polo manifestou que o objetivo da SEAPA é desenvolver os setores produtivos e grande parte dos problemas do setor florestal estão ligados à SEMA e tal assunto já está sendo tratado em conjunto com esta Secretaria.</p>\r\n<p>Ernani Polo disse que vai discutir o marco institucional com a Secretaria do Meio Ambiente (SEMA). Informou que no dia 16 de abril será realizada a 1ª reunião da Câmara Setorial de Florestas Plantadas para tratar dos assuntos do setor, inclusive sobre o marco legal. “Esse instrumento garante a segurança jurídica do silvicultor”, alegou. O Deputado Sérgio Turra colocou-se à disposição do setor florestal junto à Comissão de Agricultura e Comissão de Desenvolvimento da Assembleia Legislativa.</p>', '2015-03-26 17:00:45'),
(11, 2, 'AGEFLOR na Secretaria-Geral de Governo do Rio Grande do Sul', '<p><img class="alignleft wp-image-11 size-medium" src="http://www.ageflor.com.br/noticias/wp-content/uploads/2015/03/10865700_394632734031571_5810039696989179975_o-300x199.jpg" alt="AGEFLOR na Secretaria-Geral de Governo do RS" width="300" height="199" />A AGEFLOR esteve na Secretaria-Geral de Governo do RS para audiência com o secretário Carlos Búrigo e o secretário-adjunto Josué Barbosa. O vice-presidente de Comunicação e Eventos, Luiz Augusto Alves, representando a entidade entregou ao secretário documento também firmado pelo Sindimadeira-RS e o Sinpasul sobre atual estado e demandas do setor.</p>\r\n<p>Búrigo enfatizou que sua função é ajudar, facilitando o atendimento das demandas na <span class="text_exposed_show">interlocução com as demais pastas do governo. Um dos temas citados no encontro é a retomada de discussão sobre o projeto de lei sobre florestas plantadas, setor que hoje representa 4% do PIB gaúcho e com perspectiva de alcançar 6% com a implantação de novos projetos, a se destacar o início de operação da ampliação da Celulose Riograndense.</span></p>\r\n<div class="text_exposed_show">\r\n<p>Presentes no encontro, o diretor da organizadora da 5ª Feira da Floresta Roque Justen e o presidente da comissão organizadora do 12° Congresso Florestal do Rio Grande do Sul Doádi Brena convidaram o secretário para estar presente nos eventos que acontecem simultaneamente no período entre 11 e 15 de maio de 2015, em Nova Prata. Os eventos, aos quais também se somam o 1° Forum Sulbrasileiro da Engenharia Florestal, o Ciclo de Palestras para Produtores Rurais e o prêmio Mérito Florestal AGEFLOR, buscam sensibilizar a comunidade do que representa o setor da cadeia de base florestal.</p>\r\n<p>Participaram ainda do encontro representando o Sindimadeira o também coordenador do Comitê da Indústria de Base Florestal e Moveleira da FIERGS Serafim Quissini e o representante do Sindicato das Indústrias do Papel, Papelão e Cortiça do Rio Grande do Sul Jorge Heineck.</p>', '2015-03-26 17:00:45');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
`id` int(10) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `senha` varchar(40) NOT NULL,
  `acessos` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuarios`
--

INSERT INTO `usuarios` (`id`, `nome`, `email`, `senha`, `acessos`) VALUES
(2, 'Henrique', 'henrique@conjunto.com.br', '4badaee57fed5610012a296273158f5f', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_posts`
--
CREATE TABLE IF NOT EXISTS `view_posts` (
`id` int(10)
,`titulo` varchar(120)
,`conteudo` longtext
,`data` timestamp
,`nome` varchar(45)
,`comentarios` bigint(21)
);
-- --------------------------------------------------------

--
-- Structure for view `view_posts`
--
DROP TABLE IF EXISTS `view_posts`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_posts` AS select `posts`.`id` AS `id`,`posts`.`titulo` AS `titulo`,`posts`.`conteudo` AS `conteudo`,`posts`.`data` AS `data`,`usuarios`.`nome` AS `nome`,count(`comentarios`.`id`) AS `comentarios` from ((`posts` join `usuarios` on((`posts`.`autor` = `usuarios`.`id`))) left join `comentarios` on((`posts`.`id` = `comentarios`.`post`))) group by `posts`.`id` order by `posts`.`data` desc;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `comentarios`
--
ALTER TABLE `comentarios`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_comentarios_usuarios1_idx` (`usuario`), ADD KEY `fk_comentarios_posts1_idx` (`post`);

--
-- Indexes for table `posts`
--
ALTER TABLE `posts`
 ADD PRIMARY KEY (`id`), ADD KEY `fk_posts_usuarios_idx` (`autor`);

--
-- Indexes for table `usuarios`
--
ALTER TABLE `usuarios`
 ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `comentarios`
--
ALTER TABLE `comentarios`
MODIFY `id` int(30) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `posts`
--
ALTER TABLE `posts`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `usuarios`
--
ALTER TABLE `usuarios`
MODIFY `id` int(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `comentarios`
--
ALTER TABLE `comentarios`
ADD CONSTRAINT `fk_comentarios_posts1` FOREIGN KEY (`post`) REFERENCES `posts` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_comentarios_usuarios1` FOREIGN KEY (`usuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION;

--
-- Limitadores para a tabela `posts`
--
ALTER TABLE `posts`
ADD CONSTRAINT `fk_posts_usuarios` FOREIGN KEY (`autor`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
