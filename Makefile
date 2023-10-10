PATH_TO_PUML := /usr/local/bin/plantuml.jar

PUML_PATHS  := $(shell find . -type f -name "*.puml")
PNG_PATHS := $(patsubst %.puml,%.png,$(PUML_PATHS))

all: $(PNG_PATHS)

print:
	echo $(PNG_PATHS)

%.png: %.puml
	java -jar -Djava.awt.headless=true $(PATH_TO_PUML) $<

clean:
	rm $(PNG_PATHS)

.PHONY: all clean
