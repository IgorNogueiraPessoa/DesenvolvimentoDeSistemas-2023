-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Out-2023 às 20:19
-- Versão do servidor: 10.4.22-MariaDB
-- versão do PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `eletronic-store`
--
create database `eletronic-store`;
use `eletronic-store`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `cargo`
--

CREATE TABLE `cargo` (
  `cod_cargo` int(11) NOT NULL,
  `nome_cargo` varchar(25) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `cargo`
--

INSERT INTO `cargo` (`cod_cargo`, `nome_cargo`) VALUES
(1, 'gerente'),
(2, 'caixa');

-- --------------------------------------------------------

--
-- Estrutura da tabela `dadoscliente`
--

CREATE TABLE `dadoscliente` (
  `cod_cli` int(11) NOT NULL,
  `nome_cli` varchar(60) NOT NULL,
  `cpf_cli` varchar(14) NOT NULL,
  `email_cli` varchar(50) NOT NULL,
  `dtnasc_cli` varchar(10) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `dadoscliente`
--

INSERT INTO `dadoscliente` (`cod_cli`, `nome_cli`, `cpf_cli`, `email_cli`, `dtnasc_cli`) VALUES
(1, 'Endrigo Gustavo', '128.947.238-99', 'genshinplayer@gmail.com', '01/04/2006'),
(2, 'Ednaldo Pereira', '000.000.000-01', 'ednaldo@pereira.com', '01/01/1900'),
(3, 'Diego Gigaton', '809.849.083-29', 'gigatongames@gmail.com', '05/09/1990'),
(4, 'Rodigo Ximenes', '209.382.093-81', 'holymilk@gmail.com', '18/03/1998'),
(5, 'Dava Jonas', '565.465.465-46', 'gameplayrj@gamil.com', '15/02/1985');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

CREATE TABLE `funcionario` (
  `cod_func` int(11) NOT NULL,
  `cod_cargo` int(11) NOT NULL,
  `nome_func` varchar(60) NOT NULL,
  `email_func` varchar(50) NOT NULL,
  `tel_func` varchar(14) NOT NULL,
  `data_adms` varchar(10) NOT NULL,
  `dtnasc_func` varchar(10) NOT NULL,
  `login_func` varchar(30) NOT NULL,
  `senha_func` varchar(15) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`cod_func`, `cod_cargo`, `nome_func`, `email_func`, `tel_func`, `data_adms`, `dtnasc_func`, `login_func`, `senha_func`) VALUES
(1, 1, 'André Oliveira Paim', 'angreen2016br@gmail.com', '(11)98832-9072', '28/08/2023', '02/03/2007', 'andre', 'A400058dre'),
(2, 2, 'Bruno Aparecido Vivencio Rodrigues', 'aparecidobruno749@gmail.com', '(11)91355-5780', '28/08/2023', '15/11/2006', 'Sancho', 'Brunola911'),
(3, 2, 'Igor Nogueira Pessoa', 'igornnpessoa@gmail.com', '(11)99360-0432', '28/08/2023', '22/04/2006', 'TheBester', 'senha123@'),
(4, 1, 'Teste', 'teste@gamil.com', '(11)23434-3243', '01/01/2023', '01/01/2000', 'a', '1');

-- --------------------------------------------------------

--
-- Estrutura da tabela `itensnfiscal`
--

CREATE TABLE `itensnfiscal` (
  `cod_pro` int(11) NOT NULL,
  `cod_nota` int(11) NOT NULL,
  `qtcompra` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `notafiscal`
--

CREATE TABLE `notafiscal` (
  `cod_nota` int(11) NOT NULL,
  `cod_cli` int(11) NOT NULL,
  `cod_func` int(11) NOT NULL,
  `dtcompra_nota` date NOT NULL,
  `hr_nota` time NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `cod_pro` int(11) NOT NULL,
  `preco` double NOT NULL,
  `estoque` int(11) NOT NULL,
  `codbarras` varchar(10) NOT NULL COMMENT 'CÓDIGO 128 (padrão desse código de barras)',
  `nome_pro` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`cod_pro`, `preco`, `estoque`, `codbarras`, `nome_pro`) VALUES
(1, 4599.99, 9, '012345678', 'Xbox Series X'),
(2, 4599.99, 46, '748205715', 'Playstation 5'),
(3, 1299.99, 45, '046129572', 'Nintendo Switch'),
(4, 1299.99, 16, '022591252', 'Xbox Series S'),
(5, 1159.99, 20, '082294772', 'Playstation 4'),
(6, 1499.99, 19, '001122312', 'Nintendo GameCube'),
(7, 999.99, 7, '009189342', 'Xbox One S'),
(8, 2199.99, 10, '011199203', 'SEGA MegaDrive'),
(9, 5699.99, 46, '098112349', 'Zeebo');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `cargo`
--
ALTER TABLE `cargo`
  ADD PRIMARY KEY (`cod_cargo`);

--
-- Índices para tabela `dadoscliente`
--
ALTER TABLE `dadoscliente`
  ADD PRIMARY KEY (`cod_cli`);

--
-- Índices para tabela `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`cod_func`);

--
-- Índices para tabela `notafiscal`
--
ALTER TABLE `notafiscal`
  ADD PRIMARY KEY (`cod_nota`);

--
-- Índices para tabela `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`cod_pro`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `cargo`
--
ALTER TABLE `cargo`
  MODIFY `cod_cargo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `dadoscliente`
--
ALTER TABLE `dadoscliente`
  MODIFY `cod_cli` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `cod_func` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `notafiscal`
--
ALTER TABLE `notafiscal`
  MODIFY `cod_nota` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `produto`
--
ALTER TABLE `produto`
  MODIFY `cod_pro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
