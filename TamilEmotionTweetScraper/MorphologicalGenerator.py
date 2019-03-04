import subprocess
subprocess.call('javac -encoding utf8 MorphologicalGenerator/generate.java')
subprocess.call('java MorphologicalGenerator.generate')
