/**
 * This file is part of the "streaming-database" project.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the LICENSE is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

import javax.inject.Inject

import play.api.http.DefaultHttpFilters
import play.filters.gzip.GzipFilter

/**
 * Filters
 *
 * @author Elliot Wright <elliot@elliotwright.co>
 */
class Filters @Inject()(gzipFilter: GzipFilter) extends DefaultHttpFilters(gzipFilter)
