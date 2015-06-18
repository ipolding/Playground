from django.shortcuts import render, get_object_or_404
from django.http import HttpResponse, Http404
from django import template
from django.utils import timezone
from django.views import generic
from django.views.generic import ListView



# Create your views here.
from django.template import RequestContext, loader

from blog.models import Entry

class IndexView(generic.ListView):
    template_name = 'blog/index.html'
    context_object_name = 'latest_blog_entries'

    def get_queryset(self):
        """Return the last five published blog entries"""
        return Entry.objects.filter(pub_date__lte=timezone.now()
            ).order_by('-pub_date')[:5]


class DetailView(generic.DetailView):
    model = Entry
    template_name = 'blog/entry.html'

    def get_queryset(self):
        return Entry.objects.filter(pub_date__lte=timezone.now())


def index(request):
    latest_blog_entries = Entry.objects.order_by('-pub_date')[:5]
    # output = ', '.join([entry.title for entry in latest_blog_entries])
    # template = loader.get_template('blog/index.html')
    # context = RequestContext(request, {
    #     'latest_blog_entries': latest_blog_entries,
    # })
    context = {'latest_blog_entries': latest_blog_entries}
    # return HttpResponse(template.render(context))
    return render(request, 'blog/index.html', context)

def entry(request, entry_id):
    # return HttpResponse("You are looking at blog %s." % entry_id)
    blog_entry = get_object_or_404(Entry, pk = entry_id)
    context = {'entry' : blog_entry}

    return render(request, 'blog/entry.html', context)