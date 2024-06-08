from GetSpeechText import TextToSpeech
import random

Faces = ['the Creeper face needs to be longer ']

Fixs = ["we need to fix the creeper body too that's more like it"]

Hats = ["let's start by turning this witch into pomy the main character of The Amazing digital circus we'll need to replace the witch head and get to work reshaping this hat",
        "he most iconic part of gummy goo is that little detective hat so let's make it "]

Eyes = ["pomy also has one red eye and one blue eye that we need to add as well"]

Hairs = ["let's go ahead and give pomy her hair coming out of the hat too"]

osGood = ["this show is so good that's why I decided to remake it here in mine"]

FaceComments = ['I got to say her character and model transitioned into Minecraft very nicely.',
                'she just looks so happy to be here and her colors are so vibrant.']

MiscComments = ["let's just hope there's no fudge monsters around ", "if you for some reason attack princess Lou, she will come after you and she will start attacking you"]

details = ["but to make it even more accurate We'll add the stripes"]

Arms = ["now for the body these witch arms are not going to cut it but after some fixing they're looking quite spicy"]

Legs = [" time for the legs they are basically the same thing as the arms but you know leg shaped"]

Textures = ["obviously we can't just keep the texture looking like a creeper so we're going to make him that candy yellow and green texture"]

Summary = ["after some final detailing pomy is looking amazing", "I think he's ready to rock"]

ar = random.randint(0, 1)
br = random.randint(0, 1)
subscription_key = "412aa3b510054e959968d5ea4459e829"

final_text = FaceComments[ar] + MiscComments[br]

app = TextToSpeech(subscription_key, "sample", final_text)
app.get_token()
app.save_audio()

