from django.shortcuts import render
from django.http import HttpResponse
from django.template import RequestContext, loader
from django.core import serializers
from abstracts.models import Abstract, Journal





# Create your views here.

# class JournalSerializer(serializers.Serializer):
#     journal_title = serializers.CharField(max_length=200)

journal_manager = Journal.objects
abstracts_manager = Abstract.objects

def index(request):
    return HttpResponse("this is the index page")


def get_all_journals(request):

    all_journals_list = journal_manager.all()
    output = ', '.join(j.journal_title for j in all_journals_list)
    template = loader.get_template('abstracts/journals.html')
    context = RequestContext(request, {
        'all_journals_list': all_journals_list,
    })

    return HttpResponse(template.render(context))

def get_all_abstracts_for_journal(request, journal_title):

    abstracts_for_journal = abstracts_manager.filter(journal__journal_title__contains = journal_title)

    json_version = serializers.serialize("python", abstracts_for_journal)


    return HttpResponse(json_version, mimetype="application/json")
    # return HttpResponse(abstracts_for_journal)














