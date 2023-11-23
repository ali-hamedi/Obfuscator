# Java Obfuscator Tool with ANTLR and Python

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE.md)
[![Contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen.svg)](CONTRIBUTING.md)

## Overview

This repository contains an open-source Java code obfuscator tool developed using ANTLR for parsing and Python for advanced obfuscation techniques. The tool is designed to enhance code security by transforming Java source code into obfuscated versions, making reverse engineering more challenging.

## Getting Started

To use the obfuscator tool, follow the instructions below:

### Prerequisites

1. **Download the ANTLR Tool (Jar File):**

   - Download the ANTLR tool (Jar file) from the official website: [ANTLR Download Page](https://www.antlr.org/download/antlr-4.9.1-complete.jar)

2. **Install ANTLR Python Runtime:**

   - Install the ANTLR Python runtime using pip:
     ```bash
     pip install antlr4-python3-runtime
     ```

3. **Download the Java Grammar:**

   - Download the Java grammar files from the ANTLR grammars repository on GitHub:
     [ANTLR Grammars Repository](https://github.com/antlr/grammars-v4)

4. **Generate Tools from Grammar:**
   - Generate the tools needed from the Java grammar using the following command:
     ```bash
     antlr -Dlanguage=Python3 JavaParser.g4 JavaLexer.g4
     ```
     Replace `JavaParser.g4` and `JavaLexer.g4` with the specific grammar files you've downloaded.

### Usage

Once you've set up ANTLR and generated the necessary tools, you can integrate them into your Java obfuscator tool. Refer to the project documentation in the 'docs' directory for detailed instructions on how to use the obfuscator tool.

## Publications and Research

This obfuscator tool has been the subject of academic research, and a paper titled "Enhancing Code Privacy: An Exploratory Implementation of Java DataFlow Obfuscation" has been published at the 8th International Conference on Combinatorics, Cryptography, Computer Science and Computation (I4C 2023). The authors of the paper are Mohammadhadi Alaeiyan, Ali Hamedi, M.A. SoltanBeigi, AmirReza Parvahan, AmirAli Ghaedi. The paper is available [here](http://i4c.iust.ac.ir/UPL/Paper2023/accpapers/i4c2023-1103.pdf).

### Citing the Paper

If you find this obfuscator tool or the associated research paper useful in your work, we appreciate your citation. You can use the following BibTeX entry:

```bibtex
@inproceedings{1103,
  title={Enhancing Code Privacy: An Exploratory Implementation of Java DataFlow Obfuscation},
  author={Mohammadhadi Alaeiyan and Ali Hamedi and M.A. SoltanBeigi and AmirReza Parvahan and AmirAli Ghaedi},
  booktitle={Proceedings of the 8th International Conference on Combinatorics, Cryptography, Computer Science and Computation (I4C 2023)},
  year={2023},
  url={http://i4c.iust.ac.ir/UPL/Paper2023/accpapers/i4c2023-1103.pdf},
}
