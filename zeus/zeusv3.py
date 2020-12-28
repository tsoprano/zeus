# coding: utf-8

# In[1]:

import speech_recognition as sr
import wikipedia
import os
import wolframalpha
import pyttsx3
engine = pyttsx3.init()

# things we need for NLP
import nltk
from nltk.stem.lancaster import LancasterStemmer
stemmer = LancasterStemmer()

# things we need for Tensorflow
import numpy as np
import tflearn
import tensorflow as tf
import random


# In[2]:


# restore all of our data structures
import pickle
data = pickle.load( open( "training_data", "rb" ) )
words = data['words']
classes = data['classes']
train_x = data['train_x']
train_y = data['train_y']

# import our chat-bot intents file
import json
with open('intents.json') as json_data:
    intents = json.load(json_data)


# In[3]:


# Build neural network
net = tflearn.input_data(shape=[None, len(train_x[0])])
net = tflearn.fully_connected(net, 8)
net = tflearn.fully_connected(net, 8)
net = tflearn.fully_connected(net, len(train_y[0]), activation='softmax')
net = tflearn.regression(net)

# Define model and setup tensorboard
model = tflearn.DNN(net, tensorboard_dir='tflearn_logs')


# In[4]:


def clean_up_sentence(sentence):
    # tokenize the pattern
    sentence_words = nltk.word_tokenize(sentence)
    # stem each word
    sentence_words = [stemmer.stem(word.lower()) for word in sentence_words]
    return sentence_words

# return bag of words array: 0 or 1 for each word in the bag that exists in the sentence
def bow(sentence, words, show_details=False):
    # tokenize the pattern
    sentence_words = clean_up_sentence(sentence)
    # bag of words
    bag = [0]*len(words)  
    for s in sentence_words:
        for i,w in enumerate(words):
            if w == s: 
                bag[i] = 1
                if show_details:
                    print ("found in bag: %s" % w)

    return(np.array(bag))


# In[5]:


p = bow("is your shop open today?", words)
print (p)
print (classes)


# In[6]:


# load our saved model
model.load('./model.tflearn')


# In[7]:


# create a data structure to hold user context
context = {}

ERROR_THRESHOLD = 0.25
def classify(sentence):
    # generate probabilities from the model
    results = model.predict([bow(sentence, words)])[0]
    # filter out predictions below a threshold
    results = [[i,r] for i,r in enumerate(results) if r>ERROR_THRESHOLD]
    # sort by strength of probability
    results.sort(key=lambda x: x[1], reverse=True)
    return_list = []
    for r in results:
        return_list.append((classes[r[0]], r[1]))
    # return tuple of intent and probability
    return return_list

def response(sentence, userID='123', show_details=False):
    results = classify(sentence)
    # if we have a classification then find the matching intent tag
    if results:
        # loop as long as there are matches to process
        while results:
            for i in intents['intents']:
                # find a tag matching the first result
                if i['tag'] == results[0][0]:
                    # set context for this intent if necessary
                    if 'context_set' in i:
                        if show_details: print ('context:', i['context_set'])
                        context[userID] = i['context_set']

                    # check if this intent is contextual and applies to this user's conversation
                    if not 'context_filter' in i or                         (userID in context and 'context_filter' in i and i['context_filter'] == context[userID]):
                        if show_details: print ('tag:', i['tag'])
                        # a random response from the intent
                        p = random.choice(i['responses'])
                        print(p)
                        return p

            results.pop(0)

def zeus(input):

	if(rl.find("goodbye")>-1):
			quit()

	if(rl.find("system")>-1):	
		if (input.find("shutdown")>-1) or \
		(input.find("off")>-1):
			print("Shutting down system...")
			os.system("espeak 'Shutting down system'")
			os.system("systemctl poweroff")

		elif (input.find("restart")>-1) or \
		     (input.find("reboot")>-1):
			print("\nInitiating System Reboot")
			os.system("espeak 'Initiating system reboot'")
			os.system("systemctl reboot")

		elif (input.find("open")>-1):
			if (input.find("Firefox")>-1) or \
			   (input.find("browser")>-1):
				os.system('firefox')

		elif (input.find("volume")>-1):
			if (input.find("increase")>-1) or \
			   (input.find("up")>-1):
				os.system('amixer -D pulse sset Master 10%+')
				os.system("espeak 'Volume test'")
			elif (input.find("decrease")>-1) or\
			     (input.find("down")>-1):
				os.system('amixer -D pulse sset Master 10%-')
				os.system("espeak 'Volume test'")

	try:
		#wolframalpha
		app_id = "W9GP9A-Q23EY7XHJP"
		client = wolframalpha.Client(app_id)
		res = client.query(input)
		answer = next(res.results).text
		print(answer)
		anus = str(answer)
		engine.say(anus)
		engine.runAndWait()

	except:
		#wikipedia
		answer = wikipedia.summary(input, sentences = 2)
		print(answer)
		anus = str(answer)
		engine.say(anus)
		engine.runAndWait()


#speech recog

print("\nHello \nI am Zeus! \nYour powerful personal voice assisstant. \nHere to help you live...")
os.system("espeak 'Hello! I am Zeus. Your powerful personal voice assisstant. Here to help you live'")

#sample rate- how often values are recorded
sample_rate = 48000
#chunk is like a buffer, advisable to use powers of 2 like 1024, 2048
chunk_size = 2048
#initialise recognizer
r = sr.Recognizer()

#generate list of all audio cards and microphones
mic_list = sr.Microphone.list_microphone_names()
print(mic_list)
while True:

	#use microphone as source of input
	#we specify which device ID to look for
	#device_id undefined error if microphone doesn't work
	with sr.Microphone(sample_rate = sample_rate, chunk_size = chunk_size) as source:

		#waiting for a second to let recognizer adjust energy threshold
		#based on surrounding noise level
		r.adjust_for_ambient_noise(source)
		print ("\nTalk to me:")
		os.system("espeak 'Talk to me'")

		#listen for user input
		audio = r.listen(source, timeout = 15.0)

		try:
			text = r.recognize_google(audio)
			print ("\nYou said:" + text)
			input = str(text)

		#error occurs when google cannot understand audio
		except sr.UnknownValueError:
			print ("\nCouldn't understand audio!")
		except sr.RequestError as e:
			print ("\nCouldn't request results from speech recognition service; {0}".format(e))

		rl = str(classify(input))
		if (rl.find("fact")>-1) or (rl.find("system")>-1) or (rl.find("goodbye")>-1):
			spea = response(input)
			engine.say(spea)
			engine.runAndWait()			
			zeus(input)
		else:		
			spea = response(input)
			engine.say(spea)
			engine.runAndWait()
			
