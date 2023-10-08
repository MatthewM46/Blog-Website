
PUML_OUT = "pumlout"
PWD = $(shell pwd)

puml:
	plantuml -o $(PWD)/$(PUML_OUT) usecases/**

clean:
	rm -r $(PUML_OUT)
