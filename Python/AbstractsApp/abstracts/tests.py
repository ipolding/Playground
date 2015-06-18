import datetime
from django.utils import timezone
from django.test import TestCase
from django.core.urlresolvers import reverse

# Create your tests here.
from abstracts.models import Journal

def create_journal(title):
    time = timezone.now() - datetime.timedelta(hours=1)
    title = title + time
    return Journal.objects.create(journal_title = title)


class AbstractsViewTest(TestCase):
    def test_index_view_with_no_journals(self):
        """
        If no journals exist, an appropriate message should be displayed
        """
        response = self.client.get(reverse('abstracts:index'))
        self.assertEqual(response.status_code, 200)
        self.assertContains(response, {'journal_title' : 'Nature'})


class AbstractsMethodTests(TestCase):

    def test_is_plos_article(self):
        """
        is_plos_article should return True for jounrals with PLOS in the title
        """
        plos_journal = Journal(journal_title="PLOS Python Biology")
        self.assertEqual(plos_journal.is_plos_article(), True)



