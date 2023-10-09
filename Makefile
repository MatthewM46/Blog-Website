PUML_PATHS  := $(shell find . -type f -name "*.puml")
PNG_PATHS := $(patsubst %.puml,%.png,$(PUML_PATHS))

all: $(PNG_PATHS)

print:
	echo $(PNG_PATHS)

%.png: %.puml
	plantuml $<

clean:
	rm $(PNG_PATHS)

.PHONY: all clean
