-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Nov-2023 às 23:32
-- Versão do servidor: 10.4.27-MariaDB
-- versão do PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bd_pet`
--
create DATABASE `bd_pet`;
use `bd_pet`;
-- --------------------------------------------------------

--
-- Estrutura da tabela `pet`
--

CREATE TABLE `pet` (
  `num_registro` int(11) NOT NULL,
  `nome_pet` varchar(25) NOT NULL,
  `especie` varchar(15) NOT NULL,
  `raca` varchar(15) NOT NULL,
  `cor_predo` varchar(15) NOT NULL,
  `pet_nasc` varchar(10) NOT NULL,
  `sexo` varchar(5) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Extraindo dados da tabela `pet`
--

INSERT INTO `pet` (`num_registro`, `nome_pet`, `especie`, `raca`, `cor_predo`, `pet_nasc`, `sexo`) VALUES
(1, 'Rufus', 'Cachorro', 'SRD', 'Caramelo', '22/08/2015', 'Macho'),
(2, 'Garfield', 'Gato', 'Persa', 'Laranja', '10/10/2020', 'Macho'),
(3, 'Andrezito', 'Peixe', 'Palhaço', 'Laranja', '01/02/2023', 'Macho'),
(4, 'Alejandro', 'Cachorro', 'SRD', 'Branco', '12/02/2022', 'Macho');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `pet`
--
ALTER TABLE `pet`
  ADD PRIMARY KEY (`num_registro`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `pet`
--
ALTER TABLE `pet`
  MODIFY `num_registro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
