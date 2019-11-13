// trait TimerBase extends Base { this: Dsl =>
//   implicit def timerTyp: Typ[Timer]
//   implicit class RepTimerOps(t: Rep[Timer]) {
//     def currentTime()(implicit pos: SourceContext) = timerCurrentTime(t)
//   }
//   def newTimer()(implicit pos: SourceContext): Rep[Timer]
//   def timerCurrentTime(t: Rep[Timer])(implicit pos: SourceContext): Rep[Long]
// }
//
// trait TimerExp extends TimerBase with EffectExp { this: DslExp =>
//   implicit def timerTyp: Typ[Timer] = manifestTyp
//
//   case class TimerNew() extends Def[Timer]
//   case class TimerCurrentTime(t: Exp[Timer]) extends Def[Long]
//
//   override def newTimer()(implicit pos: SourceContext): Rep[Timer] =
//     reflectMutable(TimerNew())
//   override def timerCurrentTime(t: Rep[Timer])(implicit pos: SourceContext): Rep[Long] =
//     reflectWrite(t)(TimerCurrentTime(t))
//
//   override def mirror[A:Typ](e: Def[A], f: Transformer)(implicit pos: SourceContext): Exp[A] = (e match {
//     case Reflect(e@TimerNew(), u, es) => reflectMirrored(Reflect(TimerNew(f), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
//     case Reflect(TimerCurrentTime(t), u, es) => reflectMirrored(Reflect(TimerCurrentTime(f(t)), mapOver(f,u), f(es)))(mtype(manifest[A]), pos)
//     case _ => super.mirror(e,f)
//   }).asInstanceOf[Exp[A]]
// }
//
//
// trait ScalaGenTimer extends ScalaGenEffect {
//   val IR: TimerExp
//   import IR._
//
//   override def emitNode(sym: Sym[Any], rhs: Def[Any]) = rhs match {
//     case TimerNew() => emitValDef(sym, src"new scala.lms.tutorial.Timer()")
//     case TimerCurrentTime(t) => emitValDef(sym, src"$t.currentTime")
//     case _ => super.emitNode(sym, rhs)
//   }
// }
