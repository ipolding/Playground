
from django.utils import timezone
import string
from django.test import TestCase
from django.core.urlresolvers import reverse
import datetime
from loremipsum import get_paragraphs as get_random_paragraphs
from blog.models import Entry
# Create your tests here.



def create_entry(title, days=0):
    """ Creates a blog entry with a given title.
    The other fields are generated below
    """
    author = "Automated Test"
    pub_date = timezone.now() + datetime.timedelta(days=days)
    summary = get_random_paragraphs(1)[0]
    text = '<h1>New Paragraph </h1> <br>'.join(get_random_paragraphs(5))



    return Entry.objects.create(title=title, pub_date=pub_date, author=author,
                                summary=summary, text=text)

class BlogIndexViewTest(TestCase):
    def test_index_view_with_no_blog_entries(self):
        """
        If no entries exist, an appropriate message should be displayed
        """
        response = self.client.get(reverse('index'))
        self.assertEqual(response.status_code, 200)
        self.assertContains(response, "No blog entries are available.")
        self.assertQuerysetEqual(response.context['latest_blog_entries'], [])

    def test_index_view_with_a_past_log_entry(self):
        """
        Blog entries with a publication date <= today should be
        displayed on the the index page
        """

        create_entry("Past entry", -654)
        response = self.client.get(reverse('index'))
        self.assertQuerysetEqual(response.context['latest_blog_entries'],
            ['<Entry: Past entry>']
        )

    def test_index_view_with_a_future_log_entry(self):
        """
        Blog entries with a publication date <= today should be
        displayed on the the index page
        """

        create_entry("Future entry", 80)
        response = self.client.get(reverse('index'))
        self.assertContains(response, "No blog entries are available.", status_code = 200)
        self.assertQuerysetEqual(response.context['latest_blog_entries'], [])

    def test_index_view_with_future_blog_entry_and_past_entry(self):
        """
        Only past entries should be displayed
        """
        create_entry("Future entry", +10)
        create_entry("Past entry", -10)
        response = self.client.get(reverse('index'))
        self.assertQuerysetEqual(response.context['latest_blog_entries'],
            ['<Entry: Past entry>']
        )

    def test_index_view_with_two_past_questions(self):
            """
            The questions index page may display multiple questions.
            """
            create_entry("Past entry 1", -10)
            create_entry("Past entry 2", -5)
            response = self.client.get(reverse('index'))
            self.assertQuerysetEqual(
                response.context['latest_blog_entries'],
                ['<Entry: Past entry 2>', '<Entry: Past entry 1>']
            )

class BlogDetailViewTest(TestCase):
    def test_index_view_with_future_blog_entry(self):
        """
        If no entry exist, a 404 is raised
        """
        future_entry = create_entry("Future detail", 200)
        response = self.client.get(reverse('blog_entry', args=(future_entry.id,)))
        self.assertEqual(response.status_code, 404)

    def test_index_view_with_past_blog_entry(self):
        past_entry = create_entry("Past entry", -200)
        response = self.client.get(reverse('blog_entry', args=(past_entry.id,)))
        self.assertContains(response, past_entry.title, status_code = 200)